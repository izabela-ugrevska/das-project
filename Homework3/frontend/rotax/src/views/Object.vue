<template>
  <div>
    <h1> {{obj.name}} </h1>
    <h2>{{obj.address}}</h2>
    <h2>{{obj.phone}}</h2>
    <h2>{{obj.website}}</h2>
    <h2>{{obj.openingHours}}</h2>
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
