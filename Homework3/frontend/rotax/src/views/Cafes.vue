<template>
  <div class="cafes">
    <div id="header">
      <img src="../assets/logos/cafesLogo.png" style="padding-bottom: 3px; height: 100px;" alt="logo">
      <h6 style="..."><i>Кликнете на кафе барот за кој сте заинтересирани, и дознајте повеќе информации!</i></h6>
    </div>
    <div id="container">
      <b-container class="tableOfCafes">
        <div v-for="object in filteredCafes" :key="object.name" class="cafe">
          <template>
            <router-link :to="`/objects/cafes/${object.name}`">{{ object.name }}</router-link>
          </template>
        </div>
      </b-container>
    </div>
    <div id="footer">
      <h5 style="padding-top: 90px"><i></i></h5>
    </div>
  </div>
</template>

<script>
import cafes from '@/data/objects'
export default {
  data () {
    return {
      cafes,
      filteredCafes
    }
  }
}

var filteredCafes = []
for (let i = 0; i < cafes.length; i++) {
  if (cafes[i].category === 'cafe') {
    filteredCafes.push(cafes[i])
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
#container{
  height: 420px;
}

.cafes{
  background: lavender;
}
.tableOfCafes{
  position: absolute;
  top: 30%;
  left: 50%;
  -ms-transform: translateX(-50%) translateY(-50%);
  -webkit-transform: translate(-50%,-50%);
  transform: translate(-50%,-50%);
  width: 1000px;
}
.cafe{
  display: inline-block;
  width: 200px;
  height: 50px;
  background: lightsteelblue;
  text-align-all: center;
  margin-right: 50px;
  margin-bottom: 50px;
}
a{
  color: darkcyan;
}
a:hover{
  text-decoration: none;
  color: darkcyan;
}
</style>
