<template>
    <v-toolbar flat>
        <v-btn icon to="/profile">
            <v-avatar size="40">
                <v-img src="https://images.unsplash.com/photo-1529665253569-6d01c0eaf7b6?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cHJvZmlsZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80"></v-img>
            </v-avatar>
        </v-btn>
        <v-toolbar-title>Peers</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-menu left>
            <template v-slot:activator="{ on, attrs }">
                <v-btn icon v-bind="attrs" v-on="on">
                    <v-icon>mdi-dots-vertical</v-icon>
                </v-btn>
            </template>
            <v-list>
                <v-list-item v-for="(item, i) in items" :key="i" link>
                    <v-list-item-icon>
                    <v-icon v-text="item.icon"></v-icon>
                    </v-list-item-icon>
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item>
            </v-list>
        </v-menu>
        </v-toolbar>
</template>

<script>
export default {
    name: 'AppBar',
    data() {
        return {
            items: [
                { title: 'Settings', icon: 'mdi-cogs' },
                { title: 'Logout', icon: 'mdi-logout' }
            ],
        }
    }
}
</script>