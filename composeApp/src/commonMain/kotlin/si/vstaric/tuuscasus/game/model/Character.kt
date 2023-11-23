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
}