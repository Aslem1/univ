<template>
    <div class="container">
        <div v-if="nom">
        <h1 class="mb-4">{{ nom }}</h1>
        <b-alert v-if="fin" show>Votre score est : {{ score }} / {{ questions.length }}</b-alert>
        <b-card :header="questions[index].question"
                header-tag="header">
            <b-list-group>
                <b-list-group-item
                        button
                        v-for="(item, reponse) in questions[index].answers"
                        :key="item.id"
                        @click="action(reponse)"
                        :variant="variants[reponse]">
                    {{ item }}
                </b-list-group-item>
            </b-list-group>
            <b-button v-if="fin" @click="recommencer" class="mt-4">Recommencer !</b-button>
            <b-button v-if="fin" to="/" class="mt-4 ml-2">Choisir un autre quiz !</b-button>
            <b-button v-if="voirReponse && !fin" @click="continuer" class="mt-4">Continuer !</b-button>
        </b-card>
        </div>
        <div v-else>
            <h1>Aucune question dans cette catégorie</h1>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'quiz',
        data() {
            return {
                id: this.$route.params.id,
                fin: false,
                index: 0,
                score: 0,
                // variants est un tableau indéfini de 4 éléments correspondant aux réponses du qcm.
                variants: [...Array(4)],
                voirReponse: false,
            }
        },
        methods: {
            action(reponse) {
                if(reponse === this.questions[this.index].ok) {
                    this.score++
                } else {
                    this.variants[reponse] = 'danger'
                }
                this.voirReponse = true
                this.variants[this.questions[this.index].ok] = 'success'
                if(this.index === this.questions.length - 1) {
                    this.fin = true
                }
            },
            recommencer() {
                this.voirReponse = this.fin = this.index = this.score = 0
                this.variants = [...Array(4)]
            },
            continuer() {
                this.voirReponse = false
                this.variants = [...Array(4)]
                this.index++
            }
        },
        computed: {
            nom () {
                if (this.id < this.$store.state.quizs.length)
                    return this.$store.state.quizs[this.id].nom
                else
                    return false
            },
            questions () {
                if (this.id < this.$store.state.quizs.length)
                    return this.$store.state.quizs[this.id].questions
                else
                    return false
            }
        }
    }
</script>

<style scoped>

</style>
