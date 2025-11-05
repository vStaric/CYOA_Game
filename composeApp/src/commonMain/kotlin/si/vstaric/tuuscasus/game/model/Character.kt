package si.vstaric.tuuscasus.game.model

import si.vstaric.tuuscasus.Res

sealed class Character(
    val id: String,
    val name: String,
    val avatarIcon: String,
    val photoUrl: String
) {
    object Player : Character(
        id = "player",
        name = "You",
        avatarIcon = "https://cdn.iconscout.com/icon/free/png-256/free-avatar-370-456322.png",
        photoUrl = "https://static.vecteezy.com/system/resources/thumbnails/008/255/803/small/page-not-found-error-404-system-updates-uploading-computing-operation-installation-programs-system-maintenance-a-hand-drawn-layout-template-of-a-broken-robot-illustration-vector.jpg"
    )

    object Barista : Character(
        id = "barista",
        name = "Barista",
        avatarIcon = "https://www.svgrepo.com/show/106862/avatar.svg",
        photoUrl = "https://europeancoffeetrip.com/wp-content/uploads/2018/08/LaCabra_Station.jpg"
    )

    object OldMan : Character(
        id = "old_man",
        name = "Old Man",
        avatarIcon = "https://cdn-icons-png.flaticon.com/512/7178/7178489.png",
        photoUrl = "https://images.freeimages.com/images/large-previews/7f0/old-man-1561812.jpg"
    )

    object GardenKeeper : Character(
        id = "garden_keeper",
        name = "Garden Keeper",
        avatarIcon = "https://cdn-icons-png.flaticon.com/512/2922/2922566.png",
        photoUrl = "https://images.pexels.com/photos/8112186/pexels-photo-8112186.jpeg"
    )

    object MysteriousStranger : Character(
        id = "mysterious_stranger",
        name = "Stranger",
        avatarIcon = "https://cdn-icons-png.flaticon.com/512/4140/4140047.png",
        photoUrl = "https://images.unsplash.com/photo-1506794778202-cad84cf45f1d"
    )

    object CaveSpirit : Character(
        id = "cave_spirit",
        name = "Cave Spirit",
        avatarIcon = "https://cdn-icons-png.flaticon.com/512/5261/5261794.png",
        photoUrl = "https://images.unsplash.com/photo-1518709268805-4e9042af9f23"
    )
}