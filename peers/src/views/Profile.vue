<template>
    <div class="full-height d-flex flex-column">
        <v-toolbar v-show="this.$vuetify.breakpoint.smAndDown" class="shrink" flat>
            <v-btn icon><v-icon>mdi-arrow-left</v-icon></v-btn>
            <v-toolbar-title>Mohammad Sharief Baig</v-toolbar-title>
        </v-toolbar>
        <v-container class="fill-height">
        <v-row class="de-flex ma-auto flex-column">
                <v-avatar size="275" class="ma-auto">
                    <v-img src="https://images.unsplash.com/photo-1529665253569-6d01c0eaf7b6?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cHJvZmlsZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60"></v-img>
                </v-avatar>
                <p :class="`mx-auto mt-2 ${$vuetify.breakpoint.smAndUp ? 'text-h3' : 'text-h5'}`">Mohammad Sharief Baig</p>
                <p class="mx-auto">@mobaig</p>
                <!-- <p class="mx-auto">Lorem ipsum dolor sit amet consectetur adipisicing elit. Est asperiores obcaecati excepturi eveniet! Quia fugiat vitae quod et eos eum explicabo laborum ut expedita neque odio quo, adipisci quis accusamus.</p> -->
                <div class="d-flex justify-center">
                    <span class="d-flex flex-column align-content-center align-center">
                    <span class="text-h3">4</span>
                    <v-btn plain>Posts</v-btn>
                    </span>
                    <span class="d-flex flex-column align-content-center align-center">
                    <span class="text-h3">124</span>
                    <v-btn plain>Friends</v-btn>
                    </span>
                    <span class="d-flex flex-column align-content-center align-center">
                    <span class="text-h3">43</span>
                    <v-btn plain>Requests</v-btn>
                    </span>
                </div>
            </v-row>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'Profile'
}
</script>

<style scoped>
.full-height {
    height: 100vh;
}
.shrink {
    flex: 0;
}
.fill-height {
    flex: 1;
}
</style>