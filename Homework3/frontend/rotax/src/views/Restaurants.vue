<template>
  <div>
    <h1>Ресторани</h1>
    <b-table hover :items="filteredRestaurants">
      <template #cell(name)="data">
        <router-link :to="`/objects/:${data.value}`">{{ data.value }}</router-link>
      </template>
    </b-table>
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
