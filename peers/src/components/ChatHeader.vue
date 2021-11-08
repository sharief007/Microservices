<template>
    <v-toolbar flat>
        <v-btn icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        <v-btn icon left>
            <v-avatar size="40">
                <v-img src="https://images.unsplash.com/photo-1529665253569-6d01c0eaf7b6?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cHJvZmlsZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80"></v-img>
            </v-avatar>
        </v-btn>
        <v-toolbar-title>Sharief</v-toolbar-title>
        <v-spacer></v-spacer>
        <Call/>
        <v-speed-dial direction="bottom">
            <template v-slot:activator>
              <v-btn icon><v-icon>mdi-attachment</v-icon></v-btn>
            </template>
            <v-btn fab dark small color="green" >
              <v-icon>mdi-image</v-icon>
            </v-btn>
            <v-btn fab dark small color="indigo" >
              <v-icon>mdi-music</v-icon>
            </v-btn>
            <v-btn fab dark small color="red">
              <v-icon>mdi-video</v-icon>
            </v-btn>
            <v-btn fab dark small color="blue" >
              <v-icon>mdi-file</v-icon>
            </v-btn>
          </v-speed-dial>
          <v-menu offset-x>
            <template v-slot:activator="{ on, attrs }">
              <v-btn v-bind="attrs" v-on="on" icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>
              <v-list-item v-for="(item, index) in menuItems" :key="index">
                <v-list-item-title>{{ item.title }}</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>
    </v-toolbar>
</template>

<script>
import Call from "@/components/Call.vue";

export default {
    name: 'ChatHeader',
    components: {
      Call
    },
    data() {
      return {
       menuItems: [
          { title: 'Wallpaper' },
          { title: 'Show Media' },
          { title: 'Clear chat' },
          { title: 'Block' }
        ]
      }
    }
}
</script>

<style scoped>
.full-height {
    height: calc(100vh- 8rem);
}
</style>