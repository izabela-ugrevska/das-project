<template>
 <!-- <div id="app">
    <div id="nav">
      <router-link to="/">Дома</router-link> |
      <router-link to="/restaurants">Ресторани</router-link> |
      <router-link to="/cafes">Кафе-барови</router-link> |
      <router-link to="/markets">Маркети</router-link> |
      <router-link to="/other">Останато</router-link>
    </div>
    <router-view/>
  </div>-->
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/" class="nav-link">
            <font-awesome-icon icon="home" />Дома
          </router-link>
        </li>
        <li>
          <router-link to="/restaurants" class="nav-link"><font-awesome-icon/>Ресторани</router-link>
        </li>
       <li>
         <router-link to="/cafes" class="nav-link">Кафе-барови</router-link>
       </li>
        <li>
          <router-link to="/markets" class="nav-link">Маркети</router-link>
        </li>
        <li>
          <router-link to="/other" class="nav-link">Останато</router-link>
        </li>
      </div>

      <div v-if="!currentUser" class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/register" class="nav-link">
            <font-awesome-icon icon="user-plus" />Sign Up
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/login" class="nav-link">
            <font-awesome-icon icon="sign-in-alt" />Login
          </router-link>
        </li>
      </div>

      <div v-if="currentUser" class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" />LogOut
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
    currentUser () {
      return this.$store.state.auth.user
    }
  },
  methods: {
    logOut () {
      this.$store.dispatch('auth/logout')
      this.$router.push('/')
    }
  }
}
</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: darkcyan;
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
