<template>
  <div class="other">
    <div id="header">
      <img src="../assets/logos/otherLogo.png" style="padding-bottom: 3px; height: 100px;" alt="logo">
      <h6 style="..."><i>Кликнете објектот за кој сте заинтересирани, и дознајте повеќе информации!</i></h6>
    </div>
    <div id="container">
      <b-container class="tableOfOther">
        <b-table id="otherTable" hover :items="filteredOther">
          <template #cell(name)="data">
            <router-link :to="`/objects/:${data.value}`">{{ data.value }}</router-link>
          </template>
        </b-table>
      </b-container>
    </div>
    <div id="footer">
      <h5 style="padding-top: 90px"><i></i></h5>
    </div>
  </div>
</template>

<script>
import other from '@/data/objects'
export default {
  data () {
    return {
      other,
      filteredOther
    }
  }
}

var filteredOther = []
for (let i = 0; i < other.length; i++) {
  if (other[i].category === 'other') {
    filteredOther.push(other[i])
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

.other{
  background: lavender;
}
.tableOfOther{
  width: 200px;
  height: 200px;
  margin-top: 120px;
  margin-bottom: 100px;
  background-color: lightgray;
  font-size: 20px;
}
#otherTable td {
  display: none;
}
#otherTable td:nth-child(2) {
  display: block;
  margin-bottom: 15px;
}
#otherTable th {
  display: none;
}
a{
  color: darkcyan;
}
a:hover{
  text-decoration: none;
  color: darkcyan;
}
</style>
