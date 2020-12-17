<template>
  <div class="home">
    <div id="header">
      <img src="../assets/logo.png" style="padding-bottom: 3px; width: 270px; height: 100px;">
      <h5 style="color: darkcyan"><i>Пронајдете места пристапни со инвалидска количка</i></h5>
    </div>
    <div id="container">
      <b-container class="bv-example-row">
        <b-row style="align-content: center">
          <router-link to="/restaurants">
            <div class="category">
              <b-col>
                <h5 style="padding-top: 10px"><i>Ресторани</i></h5>
                <img src="../assets/simboli/utilities.png" style="width: 400px; height: 300px; margin-left: -100px; margin-top: -40px">
              </b-col>
            </div>
          </router-link>
          <router-link to="/cafes">
            <div class="category">
              <b-col>
                <h5 style="padding-top: 10px"><i>Кафе-барови</i></h5>
                <img src="../assets/simboli/glass.png" style="width: 350px; height: 250px; margin-left: -75px; margin-top: -30px">
              </b-col>
            </div>
          </router-link>
          <router-link to="/markets">
            <div class="category">
              <b-col>
                <h5 style="padding-top: 10px"><i>Маркети</i></h5>
                <img src="../assets/simboli/basket.png" style="width: 300px; height: 200px; margin-left: -75px; margin-top: -40px">
              </b-col>
            </div>
          </router-link>
          <router-link to="/other">
            <div class="category" style="margin-right: 0px">
              <b-col><h5 style="padding-top: 10px"><i>Останато</i></h5>
                <img src="../assets/simboli/magnifying-glass.png" style="width: 300px; height: 200px; margin-left: -60px; margin-top: -20px">
              </b-col>
            </div>
          </router-link>
        </b-row>
      </b-container>
    </div>
    <div id="footer">
      <h5 style="padding-top: 90px"><i>Инклузивноста е право а не привилегија!</i></h5>
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
