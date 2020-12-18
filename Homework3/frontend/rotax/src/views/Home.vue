<template>
  <div class="home">
    <div id="header">
      <img src="../assets/logo.png" style="padding-bottom: 3px; width: 270px; height: 100px;">
      <h5 style="color: darkcyan"><i>Пронајдете места пристапни со инвалидска количка</i></h5>
    </div>
    <div id="container">
      <b-container class="bv-example-row">
        <b-row style="align-content: center">
            <div class="category">
              <router-link to="/restaurants">
              <b-col>
                <h5 style="padding-top: 10px"><i>Ресторани</i></h5>
                <img src="../assets/Desktop/utilities.png" style="width: 110px; height: 150px; margin-left: -15px; margin-top: -10px">
              </b-col>
              </router-link>
            </div>
            <div class="category">
              <router-link to="/cafes">
              <b-col>
                <h5 style="padding-top: 10px"><i>Кафе-барови</i></h5>
                <img src="../assets/Desktop/glass.png" style="width: 150px; height: 160px; margin-left: -15px; margin-top: -10px">
              </b-col>
              </router-link>
            </div>
            <div class="category">
              <router-link to="/markets">
              <b-col>
                <h5 style="padding-top: 10px"><i>Маркети</i></h5>
                <img src="../assets/Desktop/basket.png" style="width: 130px; height: 150px; margin-left: -15px; margin-top: -10px">
              </b-col>
              </router-link>
            </div>
            <div class="category" style="margin-right: 0px">
              <router-link to="/other">
              <b-col><h5 style="padding-top: 10px"><i>Останато</i></h5>
                <img src="../assets/Desktop/magnifying-glass.png" style="width: 130px; height: 130px;  margin-top: -10px">
              </b-col>
              </router-link>
            </div>
        </b-row>
      </b-container>
    </div>
    <div id="footer">
      <h5 style="padding-top: 90px"><i>Инклузивноста е право, а не привилегија!</i></h5>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'Home'
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

  .home{
    background: lavender;
  }
  .category{
    width: 200px;
    height: 200px;
    margin-top: 120px;
    margin-bottom: 100px;
    background-color: lightgray;
    margin-right: 100px;
  }
  a{
    color: darkcyan;
  }
  a:hover{
    text-decoration: none;
    color: darkcyan;
  }
</style>
