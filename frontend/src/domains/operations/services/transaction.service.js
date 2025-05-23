import axios from 'axios'
const BASE = 'http://localhost:3000/transactions'

export default {
    async fetchByAccount(accountId) {
        const res = await axios.get(`${BASE}?accountId=${accountId}`)
        return res.data
    },
    async fetchById(id) {
        const res = await axios.get(`${BASE}/${id}`)
        return res.data
    },
    async updateStatus(id, status) {
        await axios.patch(`${BASE}/${id}`, { status })
    }
}