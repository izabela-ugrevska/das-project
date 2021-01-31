<template>
  <div class="other">
    <div class="container5">
      <h1 style="color: #f2f2f2; font-size: 64px; font-family: 'Cuprum Regular', serif; padding-top: 100px">ОСТАНАТО</h1>
      <h5 style="color: #f2f2f2; font-family: 'Cuprum Regular',serif">
        Кликнете на објектот за кој сте заинтересирани, и дознајте повеќе информации!</h5>
      <b-container class="tableOfOthers" style="padding-top: 650px">
        <div v-for="object in others" :key="object.name" class="others">
          <template>
            <router-link :to="`/objects/others/${object.objectId}`" style="color: #2A1B3C; font-size: 17px;
            font-family: Cuprum Regular, serif; text-transform: uppercase;"><b>{{ object.name }}</b></router-link>
          </template>
        </div>
      </b-container>
    </div>
    <div class="footer">
      <h5 style="color: gray; align-content: center; padding-top: 70px">rotax.herokuapp.com © Сите права се задржани - 2021</h5>
    </div>
  </div>
</template>

<script>
import ObjectAxiosData from '../data/ObjectAxiosData'
export default {
  data () {
    return {
      others: []
    }
  },
  methods: {
    // returns objects from the database from category others
    refreshOthers () {
      ObjectAxiosData.retrieveOthers().then((res) => {
        this.others = res.data
      })
    }
  },
  created () {
    this.refreshOthers()
  }
}

</script>

<style>
#header{
  align-content: center;
  background: lightgray;
  padding-bottom: 3px;
}
#footer{
  background: lightgray;
  height: 120px;

}
.container5{
  height: 645px;
  background-color: #2A1B3C;
  font-family: "Cuprum Regular", serif;
  background-image: url("../assets/logos/Позадина-ОСТАНАТО-транспарентна.png");
  background-size: 900px;
  background-repeat: no-repeat;
  background-position-x: 365px;
  background-position-y: -110px;
}

.other{
  background: lavender;
}
.tableOfOthers{
  position: absolute;
  top: 30%;
  left: 50%;
  -ms-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
  width: 1000px;
}
.others{
  display: inline-block;
  width: 200px;
  height: 50px;
  background: lightgray;
  text-align-all: center;
  margin-right: 50px;
  margin-bottom: 50px;
  border-radius: 5px;
}
a{
  color: darkcyan;
}
a:hover{
  text-decoration: none;
  color: darkcyan;
}
</style>
