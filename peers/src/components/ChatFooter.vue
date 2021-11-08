<template>
   <v-toolbar flat>
        <emoji-picker @emoji="insert" :search="search" >
        <span class="emoji-invoker" slot="emoji-invoker" slot-scope="{ events: { click: clickEvent } }" @click.stop="clickEvent">
            <v-btn icon><v-icon>mdi-emoticon</v-icon></v-btn>
        </span>
        <div slot="emoji-picker" slot-scope="{ emojis, insert }" class="emoji-picker">
            <v-card :max-width="$vuetify.breakpoint.smAndDown? '100vw' : '375px'">
                <v-tabs v-model="tab" center-active show-arrows>
                    <v-tab v-for="(emojiGroup, category) in emojis" :key="category">
                    <v-icon>{{ tabIcons[category] }}</v-icon>
                    </v-tab>
                </v-tabs>
                <v-text-field v-model="search" placeholder="Search emoji" class="mb-n5 mt-1 mx-3" rounded filled dense flat></v-text-field>
                <v-tabs-items v-model="tab">
                    <v-tab-item v-for="(emojiGroup, category) in emojis" :key="category">
                        <v-card class="overflow-y-auto" height="12rem">
                            <v-card-text class="ma-2">
                                <v-btn v-for="(emoji, emojiName) in emojiGroup" :key="emojiName" @click="insert(emoji)" :title="emojiName" class="text-h6" icon dark>
                                    {{ emoji }}
                                </v-btn>
                            </v-card-text>
                        </v-card>
                    </v-tab-item>
                </v-tabs-items>
            </v-card>
        </div>
        </emoji-picker>
        <v-text-field dense rounded filled class="message-field mt-6" v-model="messageText" placeholder="Type your message...."></v-text-field>
        <v-btn icon>
        <v-icon>mdi-send</v-icon>
        </v-btn>
    </v-toolbar>
</template>

<script>
import EmojiPicker from 'vue-emoji-picker'
export default {
    name: "ChatFooter",
    components: {
        EmojiPicker
    },
    data() {
        return {
            tab: null,
            messageText: '',
            search: '',
            tabIcons : {
                "People":"mdi-emoticon-happy-outline",
                "Nature":"mdi-flower",
                "Objects":"mdi-tools",
                "Places":"mdi-car",
                "Symbols":"mdi-symbol",
                "Frequently used":"mdi-history"
            },
        }
    },
    methods: {
        insert(emoji) {
            this.messageText += emoji
        },
    }
}
</script>

<style scoped>
.emoji-picker {
  position: absolute;
  z-index: 1;
  box-sizing: border-box;
  bottom: 100%;
  left: 0%;
}
</style>