var vm = new Vue({
    el: '#app',
    data() {
        return {
            photos: [
                {
                    lien : 'images/photo1.jpg',
                    titre: 'Pieuvre',
                    mini: 'images/minis/m_photo1.jpg'
                },
                {
                    lien : 'images/photo2.jpg',
                    titre: 'Feuille',
                    mini: 'images/minis/m_photo2.jpg'
                },
                {
                    lien : 'images/photo3.jpg',
                    titre: 'Temple',
                    mini: 'images/minis/m_photo3.jpg'
                },
                {
                    lien : 'images/photo4.jpg',
                    titre: 'Feu',
                    mini: 'images/minis/m_photo4.jpg'
                },
                {
                    lien : 'images/photo5.jpg',
                    titre: 'Cascade',
                    mini: 'images/minis/m_photo5.jpg'
                },
                {
                    lien : 'images/photo6.jpg',
                    titre: 'Monde',
                    mini: 'images/minis/m_photo6.jpg'
                },
                {
                    lien : 'images/photo7.jpg',
                    titre: 'Tam Tam',
                    mini: 'images/minis/m_photo7.jpg'
                },
            ],
            image: 'images/photo1.jpg',
            titre: 'Pieuvre'
        }

    },
    methods: {
        changePhoto(p) {
            this.image=p.lien
            this.titre=p.titre
        }
    }
});
