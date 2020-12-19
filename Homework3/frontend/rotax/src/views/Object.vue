<template>
  <div>
    <div id="header1" style="font-family: Helvetica; font-size: 100px; font-style: italic">
      <h1>{{obj.name}}</h1>
    </div>
    <div id="container1">
      <b-container>
        <b-row style="align-content: space-evenly">

          <b-col v-show="obj.phone!=''">
            <img src="../assets/Desktop/phone.png" style="height: 100px;">
            <h6>{{obj.phone}}</h6>
          </b-col>
          <b-col v-show="obj.website != ''">
            <img src="../assets/Desktop/www.png" style="height: 100px;">
            <h6>{{obj.website}}</h6>
          </b-col>
          <b-col v-show="obj.openingHours!=''">
            <img src="../assets/Desktop/clock.png" style="height: 100px;">
            <h6>{{obj.openingHours}}</h6>
          </b-col>
          <b-col v-show="obj.smokingtype===true">
            <img src="../assets/Desktop/cigarette.png" style="height: 100px;">
            <h6>Дозволено</h6>
          </b-col>
          <b-col v-show="obj.outdoorSeating===true">
            <img src="../assets/Desktop/leaf.png" style="height: 100px;">
            <h6>има надворешен дел</h6>
          </b-col>
          <b-col v-show="obj.cuisine!=null">
            <img src="../assets/Desktop/utilities.png" style="height: 100px">
            <h6>Кујна: {{obj.cuisine}}</h6>
          </b-col>
        </b-row>
      </b-container>
    </div>
    <div id="footer">
      <h5 style="padding-top: 90px"><i></i></h5>
    </div>
  </div>

</template>
<script>
import { mapState } from 'vuex'
import objects from '@/data/objects'
export default {
  data () {
    return {
      obj: {}
    }
  },
  computed: {
    ...mapState([
      'objects'
    ])
  },
  mounted () {
    const name = this.$route.params.id
    for (let i = 0; i < objects.length; i++) {
      if (name === objects[i].name) {
        this.obj = objects[i]
      }
    }
    console.log(this.obj.name)
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
#container1{
  height: 500px;
  background: darkslategrey;
}
#footer{
  background: lightgray;
  height: 120px;
}
</style>
