import axios from 'axios'

const OBJECT_API_URL = 'http://localhost:8081/objects'

class ObjectAxiosData {
  retrieveAllObjects () {
    return axios.get(`${OBJECT_API_URL}`)
  }

  retrieveObjectById (id) {
    return axios.get(`${OBJECT_API_URL}/${id}`)
  }

  retrieveCafes () {
    return axios.get(`${OBJECT_API_URL}/category/cafe`)
  }

  retrieveRestaurants () {
    return axios.get(`${OBJECT_API_URL}/category/restaurant`)
  }

  retrieveMarkets () {
    return axios.get(`${OBJECT_API_URL}/category/market`)
  }

  retrieveOthers () {
    return axios.get(`${OBJECT_API_URL}/category/other`)
  }
}

export default new ObjectAxiosData()
