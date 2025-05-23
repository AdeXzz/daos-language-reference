import axios from 'axios'
const BASE = 'http://localhost:3000/accounts'

export default {
    async fetchAll() {
        const res = await axios.get(BASE)
        return res.data
    }
}