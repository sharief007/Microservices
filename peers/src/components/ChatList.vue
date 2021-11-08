<template>
    <!-- <v-card> -->
      <v-list subheader two-line class="overflow-y-auto" height="calc(100vh - 11rem)">
      <v-subheader>Recent Chats</v-subheader>
      <v-list-item v-for="(item,index) in $store.state.chatList" :key="index" link>
        <v-list-item-avatar>
          <v-img src="https://images.unsplash.com/photo-1457449940276-e8deed18bfff?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8cHJvZmlsZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60"></v-img>
        </v-list-item-avatar>
        <v-list-item-content>
          <v-list-item-title v-text="item.name"></v-list-item-title>
          <v-list-item-subtitle v-text="item.message"></v-list-item-subtitle>
        </v-list-item-content>
        <v-list-item-action>
          <v-badge :content="item.new"></v-badge>
        </v-list-item-action>
      </v-list-item>
    </v-list>
    <!-- </v-card> -->
</template>

<script>
export default {
    name: 'ChatList',
    data() {
        return {
          
        }
    }
}
</script>