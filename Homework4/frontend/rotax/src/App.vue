<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark" style="background-color: #2A1B3C; font-family:Cuprum Regular" >
      <div class="navbar-nav mr-auto" style="align-content: center;">
        <img src="@/assets/logos/logo.png" style="height: 50px">
        <li class="nav-item">
          <router-link to="/" class="nav-link" style="color: #f2f2f2; padding-left: 325px; font-size: 17px">
           ДОМА
          </router-link>
        </li>
        <li>
          <router-link to="/restaurants" class="nav-link" style="color: #f2f2f2;padding-left: 70px; font-size: 17px">РЕСТОРАНИ</router-link>
        </li>
       <li>
         <router-link to="/cafes" class="nav-link" style="color: #f2f2f2;padding-left: 70px; font-size: 17px">КАФЕ-БАРОВИ</router-link>
       </li>
        <li>
          <router-link to="/markets" class="nav-link" style="color: #f2f2f2;padding-left: 70px; font-size: 17px">МАРКЕТИ</router-link>
        </li>
        <li>
          <router-link to="/other" class="nav-link" style="color: #f2f2f2;padding-left: 70px; font-size: 17px">ОСТАНАТО</router-link>
        </li>
      </div>
      <div v-if="!currentUser" class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/register" class="nav-link" style="color: #E98074; font-size: 17px">
            SIGN UP
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/login" class="nav-link" style="color: #E98074; font-size: 17px">
           LOGIN
          </router-link>
        </li>
      </div>

      <div v-if="currentUser" class="navbar-nav ml-auto" style="color: #E98074">
        <li class="nav-item" style="color: #E98074">
          <a class="nav-link" href @click.prevent="logOut" STYLE="color: #E98074; font-size: 17px">
            LOG OUT
          </a>
        </li>
      </div>
    </nav>
    <router-view />
  </div>
</template>
<script>
export default {
  computed: {
    // checks if there is a user logged in
    currentUser () {
      return this.$store.state.auth.user
    }
  },
  methods: {
    // calls the logout method for the user currently logged in
    logOut () {
      this.$store.dispatch('auth/logout')
      this.$router.push('/')
    }
  }
}
</script>
<style lang="scss">
#app {
  font-family: "Cuprum Regular",serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2A1B3C;
}

#nav {
  padding: 10px;
  background: lightgray;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: darkcyan;
    }
  }
}
</style>
<style>
@font-face {
  font-family: "Cuprum Regular";
  src: local("Cuprum Regular"),
  url(fonts/Cuprum/static/Cuprum-Regular.ttf) format("truetype");
}
</style>
