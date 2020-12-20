<template>
  <div id="full">
    <div id="header1" style="font-family: Helvetica; font-size: 100px; font-style: italic">
      <h1>{{obj.name}}</h1>
    </div>
    <div id="container1">
      <b-container>
        <b-row style="align-content: space-evenly">

          <b-col v-show="obj.phone!=''"> <br> <br>
            <img src="../assets/Desktop/phone.png" style="height: 100px;">
            <h6>{{obj.phone}}</h6>
          </b-col>
          <b-col v-show="obj.website != ''"> <br> <br>
            <img src="../assets/Desktop/www.png" style="height: 100px;">
            <h6>{{obj.website}}</h6>
          </b-col>
          <b-col v-show="obj.openingHours!=''"> <br> <br>
            <img src="../assets/Desktop/clock.png" style="height: 100px;">
            <h6>{{obj.openingHours}}</h6>
          </b-col>
          <b-col v-show="obj.smokingtype===true"> <br> <br>
            <img src="../assets/Desktop/cigarette.png" style="height: 100px;">
            <h6>Дозволено</h6>
          </b-col>
          <b-col v-show="obj.outdoorSeating===true"> <br> <br>
            <img src="../assets/Desktop/leaf.png" style="height: 100px;">
            <h6>има надворешен дел</h6>
          </b-col>
          <b-col v-show="obj.category=='restaurant' && obj.cuisine!=null"> <br> <br>
            <img src="../assets/Desktop/utilities.png" style="height: 100px">
            <h6>Кујна: {{obj.cuisine}}</h6>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <div id="map">
              <GmapMap
                :center="{lat: parseFloat(obj.latitude), lng: parseFloat(obj.longitude)}"
                :zoom="18"
                style="width:400px; height:250px; margin: 32px auto;"></GmapMap>
            </div>
          </b-col>
        </b-row>
      </b-container>
    </div>
    <b-container>
      <b-form-rating v-model="rate_1" v-on:change="average"></b-form-rating>
      <code>Оцена: {{rate_1}}</code> <br>
      <code>Просечна оцена: {{averageRate}} / 5</code> <br>
    </b-container>
    <div class="reviews">
      <div class="add-review">
        <input type="text" id="addReview"><input type="button" value="Add">
      </div>
      <div class="review" v-for="review in obj.reviews" :key="review">
        {{review}}
      </div>
    </div>
    <div id="footer">
      <h5 style="padding-top: 90px"><i></i></h5>
    </div>
  </div>

</template>
<script>
import { mapState } from 'vuex'
import ObjectAxiosData from '../data/ObjectAxiosData'

export default {
  data () {
    return {
      obj: {},
      rate_1: null,
      total: 0,
      counter: 0,
      averageRate: null,
      user: JSON.parse(localStorage.getItem('user'))
    }
  },
  mounted () {
    const prosek = this.average()
    this.$set(this.obj, 'averageRating', prosek) // so ova se dodava nov property na object
    console.log(this.obj.averageRating)
  },
  methods: {
    refreshObject () {
      ObjectAxiosData.retrieveObjectById(this.id).then((res) => {
        this.obj = res.data
      })
    },
    average: function () {
      this.counter++
      var rating = this.rate_1
      this.total += rating
      this.averageRate = (this.total / this.counter).toFixed(2)
      return this.averageRate
    }
  },
  created () {
    this.refreshObject()
  },
  computed: {
    ...mapState([
      'objects'
    ]),
    id () {
      console.log(this.$route.params.id)
      return this.$route.params.id
    }
  }
}
</script>

<style>
#header1{
  align-content: center;
  background: lightgray;
  padding-bottom: 35px;
  padding-top: 35px;
}
#full{
  background: lavender;
}
#container1{
  height: 500px;
  background: lavender;
}
#addReview{
  length: 200px;
  width: 600px;
}
#footer{
  background: lightgray;
  height: 120px;
}
</style>
