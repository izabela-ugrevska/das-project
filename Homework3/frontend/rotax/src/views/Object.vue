<template>
  <div>
    <h1>Object</h1>
    <h1> {{obj.address}} </h1>
    <h1>{{obj.name}}</h1>
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
    const parts = name.split(':')
    for (let i = 0; i < objects.length; i++) {
      if (parts[1] === objects[i].name) {
        this.obj = objects[i]
      }
    }
  }
}
</script>
