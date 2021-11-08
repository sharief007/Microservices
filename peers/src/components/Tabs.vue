<template>
  <v-card class="full-height" flat>
    <v-tabs v-model="tab" grow>
      <v-tab v-for="(item,index) in items" :key="index">
        <v-badge :value="item.badge" dot><v-icon left v-text="item.icon"></v-icon>{{ item.title }}</v-badge>
      </v-tab>
    </v-tabs>
    <v-toolbar flat>
        <v-text-field prepend-inner-icon="mdi-magnify" clearable dense rounded filled class="pt-6" placeholder="Search"></v-text-field>
    </v-toolbar>
    <v-tabs-items v-model="tab">
      <v-tab-item v-for="(item,index) in items" :key="index">
        <ChatList/>
      </v-tab-item>
    </v-tabs-items>
  </v-card>
</template>

<script>
import ChatList from "@/components/ChatList.vue";

export default {
   name: 'Tabs',
   components: {
     ChatList
   },
   data() {
       return {
            tab: null,
            items: [
              { title: 'Chats', icon: 'mdi-chat', badge: true},
              { title: 'Explore', icon: 'mdi-chart-bubble', badge: false},
              { title: 'Friends', icon: 'mdi-account-group', badge: false}
            ],
      }
   }
}
</script>

<style scoped>
.full-height {
    height: calc(100vh - 4rem);
}
</style>