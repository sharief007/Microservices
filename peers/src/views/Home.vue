<template>
    <div>
      <chat-header/>
      <v-progress-linear v-if="$store.state.messageLoading"></v-progress-linear>
      <messages/>
      <chat-footer/>
    </div>
</template>

<script>
import ChatHeader from "@/components/ChatHeader.vue"
import Messages from "@/components/Messages.vue"
import ChatFooter from "@/components/ChatFooter.vue"

export default {
    name: 'Home',
    components: {
      ChatHeader,
      Messages,
      ChatFooter
    }
}
</script>

<style scoped>
.full-height {
    height: calc(100vh- 8rem);
}
</style>