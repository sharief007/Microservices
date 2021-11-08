<template>
  <v-app>
    <v-row no-gutters>
      <v-col sm="4">
        <AppBar/>
        <Tabs/>
      </v-col>
      <v-divider vertical></v-divider>
      <v-col sm="8">
        <router-view/>
      </v-col>
    </v-row>
  </v-app>
</template>

<script>
import AppBar from "@/components/AppBar";
import Tabs from "@/components/Tabs";

export default {
  components: {
    AppBar,
    Tabs
  },
  created() {
    this.$vuetify.theme.dark = !this.$vuetify.theme.dark;
    this.$store.dispatch('createStompClient')
  }
}
</script>
