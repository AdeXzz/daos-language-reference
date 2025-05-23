import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/router.js";
import i18n from "./i18n/i18n.js";
import PrimeVue from "primevue/config";
import Aura from '@primeuix/themes/aura';
import Button from 'primevue/button'
import Card from 'primevue/card'
import InputText from 'primevue/inputtext'
import Toolbar from 'primevue/toolbar'
import Select from 'primevue/select'

import "primeicons/primeicons.css";
const app = createApp(App);
app.use(PrimeVue, {
    theme: {
        preset: Aura
    }
});

app.use(router);
app.use(i18n);
app.use(PrimeVue);

app.component('pv-button', Button)
app.component('pv-card', Card)
app.component('pv-input-text', InputText)
app.component('pv-toolbar', Toolbar)
app.component('pv-select', Select)

app.mount('#app')