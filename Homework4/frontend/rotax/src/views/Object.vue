<template>
  <div id="full">
    <div class="container6">
      <h1 style="font-family:Cuprum Regular,serif; font-size: 65px; color: #f2f2f2; padding-top: 25px">{{obj.name}}</h1>
      <b-container style="color: #f2f2f2">
        <b-row style="align-content: space-evenly">

          <b-col v-show="obj.phone!=''"><br> <br>
            <img src="../assets/Desktop/phone.png" style="height: 100px;">
            <h6>{{obj.phone}}</h6>
          </b-col>
          <b-col v-show="obj.website != ''"><br> <br>
            <img src="../assets/Desktop/www.png" style="height: 100px;">
            <h6>{{obj.website}}</h6>
          </b-col>
          <b-col v-show="obj.openingHours!=''"><br> <br>
            <img src="../assets/Desktop/clock.png" style="height: 100px;">
            <h6>{{obj.openingHours}}</h6>
          </b-col>
          <b-col v-show="obj.smoking === true"><br> <br>
            <img src="../assets/Desktop/cigarette.png" style="height: 100px;">
            <h6>Дозволено</h6>
          </b-col>
          <b-col v-show="obj.outdoorSeating===true"><br> <br>
            <img src="../assets/Desktop/leaf.png" style="height: 100px;">
            <h6>Има надворешен дел</h6>
          </b-col>
          <b-col v-show="obj.cuisine != null"><br> <br>
            <img src="../assets/Desktop/utilities.png" style="height: 100px">
            <h6>Кујна: {{obj.cuisine}}</h6>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <div id="map" style="padding-top: 40px">
              <GmapMap
                :center="{lat: parseFloat(obj.latitude), lng: parseFloat(obj.longitude)}"
                :zoom="18"
                style="width:900px; height:260px; margin: 32px auto;">
                <GmapMarker
                  :key="index"
                  :position="{lat: parseFloat(obj.latitude), lng: parseFloat(obj.longitude)}"
                  :clickable="true"
                  :draggable="true"
                />
              </GmapMap>
            </div>
          </b-col>
        </b-row>
      </b-container>
    </div>
    <b-container style="color: #f2f2f2">
      <b-col v-show="obj.rating!=null">
        <h4>Rating : {{ obj.rating }}</h4>
      </b-col>
      <b-form-group id="input-group-4" label="Give Us Rating:" style="color: #f2f2f2; font-size: 35px">
        <b-form-radio-group
          v-model="rating"
          id="radios"
        >
          <b-form-radio  value="1"><b style="color: #f2f2f2">1</b></b-form-radio>
          <b-form-radio value="2"><b style="color: #f2f2f2">2</b></b-form-radio>
          <b-form-radio value="3"><b style="color: #f2f2f2">3</b></b-form-radio>
          <b-form-radio value="4"><b style="color: #f2f2f2">4</b></b-form-radio>
          <b-form-radio value="5"><b style="color: #f2f2f2">5</b></b-form-radio>
        </b-form-radio-group>
      </b-form-group>
    </b-container>
    <br>
    <div class="reviews">
      <div class="add-review">
        <input type="text" id="addReview" v-model="comment"> <input type="button" v-on:click="addReview()" value="ADD" style="background-color: #2A1B3C; color: #f2f2f2; font-family: 'Cuprum Regular',serif">
      </div>
      <div class="review" v-for="review in obj.reviews" :key="review.reviewId">
        <p style="color: #f2f2f2"> {{review.rating}} {{review.comment}} </p>
      </div>
    </div>
    <div class="footer">
      <h5 style="color: gray; align-content: center; padding-top: 70px">rotax.herokuapp.com © Сите права се задржани - 2021</h5>
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
      rating: [],
      comment: [],
      user: JSON.parse(localStorage.getItem('user'))
    }
  },
  methods: {
    // retrieves object from database by id
    refreshObject () {
      ObjectAxiosData.retrieveObjectById(this.id).then((res) => {
        this.obj = res.data
      })
    },
    // creates a new review for a given object from a given user
    addReview () {
      ObjectAxiosData.createReview(this.obj.objectId, this.user.username, {
        rating: this.rating,
        comment: this.comment
      }).then(() => {
        this.refreshObject()
      })
    },
    // validates the input from the user (checks if the user has left a rating for the object
    // if the rating is not null it submits the review
    validateAndSubmit (e) {
      e.preventDefault()
      this.errors = []
      if (!this.rating) {
        this.errors.push('Please choose rating')
      }
      if (this.errors.length === 0) {
        ObjectAxiosData.createReview(this.obj.objectId, this.user.username, {
          rating: this.rating,
          comment: this.comment
        }).then(() => {
          this.refreshObject()
        })
      }
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
  #header1 {
    align-content: center;
    background: lightgray;
    padding-bottom: 35px;
    padding-top: 35px;
  }

  #full {
    background: #2A1B3C;
  }

  .container6 {
    height: 700px;
    background: #2A1B3C;
  }

  #addReview {
    length: 200px;
    width: 600px;
  }

  #footer {
    background: lightgray;
    height: 120px;
  }

</style>
