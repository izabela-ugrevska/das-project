<template>
  <div>
    <h1>Ресторани</h1>
    <ul id="restaurantList">
      <li v-for="restaurant in filteredRestaurants" :key="restaurant.name">
        {{ restaurant.name }}
      </li>
    </ul>
  </div>
</template>

<script>
import restaurants from '@/data/objects'
export default {
  data () {
    return {
      restaurants,
      filteredRestaurants
    }
  }
}

var filteredRestaurants = []
for (let i = 0; i < restaurants.length; i++) {
  if (restaurants[i].category === 'restaurant') {
    filteredRestaurants.push(restaurants[i])
  }
}
</script>
