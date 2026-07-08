package com.asadmansoor.fighter.data

interface MonsterApi {
    suspend fun getMonsters(): List<Monster>
}

class MockMonsterApi : MonsterApi {

    override suspend fun getMonsters(): List<Monster> = monsters

    private val monsters = listOf(
        Monster(
            name = "Bat",
            image = "bat",
            backgroundColor = "#2E2A4F",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Duckling",
            image = "duckling",
            backgroundColor = "#FFE082",
            haptic = "swell",
        ),
        Monster(
            name = "Bunny",
            image = "bunny",
            backgroundColor = "#F8BBD0",
            haptic = "heartbeat",
        ),
        Monster(
            name = "Jellyfish",
            image = "jellyfish",
            backgroundColor = "#4DD0E1",
            haptic = "bounce",
        ),
        Monster(
            name = "Lion",
            image = "lion",
            backgroundColor = "#FFB74D",
            haptic = "roar",
        ),
        Monster(
            name = "Alien",
            image = "alien",
            backgroundColor = "#81C784",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Squid Alien",
            image = "squid_alien",
            backgroundColor = "#9575CD",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Flame",
            image = "flame",
            backgroundColor = "#FF7043",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Cookie",
            image = "cookie",
            backgroundColor = "#D7A86E",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Ghost",
            image = "ghost",
            backgroundColor = "#B0BEC5",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Monster",
            image = "monster",
            backgroundColor = "#7E57C2",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Alien Monster",
            image = "alien_monster",
            backgroundColor = "#66BB6A",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Enemy Monster",
            image = "enemy_monster",
            backgroundColor = "#EF5350",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Spooky Monster",
            image = "spooky_monster",
            backgroundColor = "#5C6BC0",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Scary Monster",
            image = "scary_monster",
            backgroundColor = "#26A69A",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Creepy Monster",
            image = "creepy_monster",
            backgroundColor = "#AB47BC",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Skeleton",
            image = "skeleton",
            backgroundColor = "#CFD8DC",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Ghoul",
            image = "ghoul",
            backgroundColor = "#8D6E63",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Sticker Monster",
            image = "sticker_monster",
            backgroundColor = "#42A5F5",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Pumpkin",
            image = "pumpkin",
            backgroundColor = "#FF8A65",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Skull",
            image = "skull",
            backgroundColor = "#90A4AE",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Bee",
            image = "bee",
            backgroundColor = "#FFD54F",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Frog",
            image = "frog",
            backgroundColor = "#9CCC65",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Spider",
            image = "spider",
            backgroundColor = "#546E7A",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Cactus",
            image = "cactus",
            backgroundColor = "#4DB6AC",
            haptic = "ramp_up",
        ),
        Monster(
            name = "Mushroom",
            image = "mushroom",
            backgroundColor = "#E57373",
            haptic = "ramp_up",
        ),
    )
}
