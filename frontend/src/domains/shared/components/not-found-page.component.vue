<template>
  <div class="not-found">
    <h1>404 - {{ $route.path }}</h1>
    <p>{{ $t('pageNotFound') }}</p>
    <button @click="$router.push('/home')">{{ $t('backHome') }}</button>
  </div>
</template>

<script>
export default { name: 'NotFoundPage' }
</script>

<style>
.not-found {
  padding: 2rem;
  text-align: center;
}
.not-found button {
  margin-top: 1rem;
}
</style>