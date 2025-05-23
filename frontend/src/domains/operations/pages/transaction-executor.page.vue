<template>
  <div class="page-container">
    <the-toolbar />
    <h1 class="page-title" aria-label="Transaction Execution">{{ $t("transactionExecution") }}</h1>
    <transaction-validator />
  </div>
</template>

<script>
import TheToolbar from '../../public/components/the-toolbar.component.vue'
import TransactionValidator from '@/domains/operations/components/transaction-validator.component.vue'

export default {
  name: 'transaction-executor',
  components: {
    TheToolbar,
    TransactionValidator
  }
}
</script>

<style scoped>
.page-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 2rem;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  background-color: #ffffff;
  color: #333;
}

.page-title {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 1.5rem;
  color: #2c3e50;
}
</style>