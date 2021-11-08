<template>
    <v-dialog v-model="dialog" fullscreen hide-overlay>
        <template v-slot:activator="{ on, attrs }">
            <v-btn icon v-bind="attrs" v-on="on"><v-icon>mdi-video</v-icon></v-btn>
        </template>
        <v-card>
            <v-toolbar absolute class="controls" :color="color"  flat>
                <v-btn icon @click="captureMedia"><v-icon>mdi-close</v-icon></v-btn>
                <v-toolbar-title>Settings</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-btn icon @click="toggleControlsOpacity"><v-icon>mdi-water-opacity</v-icon></v-btn>
                <v-btn icon @click="closeMedia" ><v-icon>mdi-microphone-off</v-icon></v-btn>
                <v-btn icon @click="closeMedia"><v-icon>mdi-volume-high</v-icon></v-btn>
                <v-btn dark icon @click="closeMedia" class="red"><v-icon>mdi-phone-hangup</v-icon></v-btn>
            </v-toolbar>
            <div class="div-container">
                <video ref="myVideo" class="my-video" autoplay></video>
                <video ref="video2" class="video2" autoplay></video>
            </div>
        </v-card>
    </v-dialog>
</template>

<script>
// import Peer from 'peerjs';

export default {
    name: 'Call',
    data() {
        return {
            dialog: null,
            stream: null,
            color: null
        }
    },
    methods: {
        captureMedia() {
            const hdConstraints = {
                video: { width: { min: 1280 }, height: { min: 720 } },
                // video: true
            };
            console.log(this.$refs);
            if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
                navigator.mediaDevices.getUserMedia(hdConstraints).then((stream) => {
                    this.stream = stream
                    this.$refs["myVideo"].srcObject = stream;
                    this.$refs["video2"].srcObject = stream;
                });
                // var peer = new Peer(undefined, {
                //     host: '/',
                //     port: 3001
                // })
                // console.log(peer);
            }
        },
        closeMedia() {
            this.stream.getTracks().forEach(track => track.stop());
            this.dialog = false;
        },
        toggleControlsOpacity() {
            this.color = this.color ? null : 'transparent'
        }
    }
}
</script>

<style scoped>
.controls {
    min-width: 100vw;
    max-width: 100vw;
}
.div-container {
    display: flex;
    width: 100%;
    height: 100%;
}
.my-video {
    width: auto;
    max-width: 100vw;
    min-height: 100vh;
    max-height: 100vh;
    margin: auto;
}

.video2 {
    width: 250px;
    height: 150px;
    position: absolute;
    top: 10%;
    left: 0%;
}
</style>