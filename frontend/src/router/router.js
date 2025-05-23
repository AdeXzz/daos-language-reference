import { createRouter, createWebHistory } from 'vue-router'
import TheHomePage from '@/domains/public/pages/the-home.page.vue'
import TransactionExecutorPage from '@/domains/operations/pages/transaction-executor.page.vue'
import NotFoundPage from '@/domains/shared/components/not-found-page.component.vue'

export default createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', redirect: '/home' },
        { path: '/home', component: TheHomePage },
        { path: '/transactions/execute', component: TransactionExecutorPage },
        { path: '/:pathMatch(.*)*', name: 'NotFound', component: NotFoundPage }
    ]
})