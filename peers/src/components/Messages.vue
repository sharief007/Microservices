<template>
    <div class="chat-box" v-on:scroll="onScroll" ref="chatBox">
        <div v-for="(item) in $store.state.messageItems" :class="item.sent? 'message-sent':'message-received'" :key="item.id">
            <div :class="item.sent? 'message-sent-content':'message-received-content'">{{item.message}}</div>
        </div>
    </div>
</template>

<script>
export default ({
    name: 'Messages',
    data() {
        return {
            
        }
    },
    methods: {
      onScroll() {
        let chatBox = this.$refs['chatBox']
        if(chatBox.scrollTop<10) {
          console.log(chatBox);
        }
      }
    },
    mounted() {
      let chatBox = this.$refs['chatBox']
      chatBox.scrollTop = chatBox.scrollHeight
    }
})
</script>

<style scoped>
.chat-box {
  flex: 1;
  overflow-y: auto;
  min-height: calc(100vh - 8rem);
  max-height: calc(100vh - 8rem);
  padding: 0 10px;
}
.message-sent {
  padding: 5px;
	display: grid;
	grid-template-columns: 85%;
	justify-items: end;
    border-radius: 15px 0 15px 15px;
    justify-content: end;
}
.message-received {
  padding: 5px;
	display: grid;
	grid-template-columns: 85%;
    justify-items: start;
    border-radius: 0px 15px 15px 15px;
}
.message-sent-content {
  border-radius: 15px 15px 0px 15px;
  background-color: #0275d8;
  color: white;
  padding: 5px 10px;
}
.message-received-content {
  border-radius: 0px 15px 15px 15px;
  /* background-color: #F0F0F0;; */
  background-color: #383838;
  padding: 5px 10px;
}
</style>