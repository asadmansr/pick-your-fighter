package com.asadmansoor.fighter.data

interface MonsterApi {
    suspend fun getMonsters(): List<Monster>
}

class MockMonsterApi : MonsterApi {

    override suspend fun getMonsters(): List<Monster> = monsters

    private val monsters = listOf(
        Monster(name = "Bat", image = "bat", backgroundColor = "#2E2A4F"),
        Monster(name = "Duckling", image = "duckling", backgroundColor = "#FFE082"),
        Monster(name = "Bunny", image = "bunny", backgroundColor = "#F8BBD0"),
        Monster(name = "Jellyfish", image = "jellyfish", backgroundColor = "#4DD0E1"),
        Monster(name = "Lion", image = "lion", backgroundColor = "#FFB74D"),
        Monster(name = "Alien", image = "alien", backgroundColor = "#81C784"),
        Monster(name = "Squid Alien", image = "squid_alien", backgroundColor = "#9575CD"),
        Monster(name = "Flame", image = "flame", backgroundColor = "#FF7043"),
        Monster(name = "Cookie", image = "cookie", backgroundColor = "#D7A86E"),
        Monster(name = "Ghost", image = "ghost", backgroundColor = "#B0BEC5"),
        Monster(name = "Monster", image = "monster", backgroundColor = "#7E57C2"),
        Monster(name = "Alien Monster", image = "alien_monster", backgroundColor = "#66BB6A"),
        Monster(name = "Enemy Monster", image = "enemy_monster", backgroundColor = "#EF5350"),
        Monster(name = "Spooky Monster", image = "spooky_monster", backgroundColor = "#5C6BC0"),
        Monster(name = "Scary Monster", image = "scary_monster", backgroundColor = "#26A69A"),
        Monster(name = "Creepy Monster", image = "creepy_monster", backgroundColor = "#AB47BC"),
        Monster(name = "Skeleton", image = "skeleton", backgroundColor = "#CFD8DC"),
        Monster(name = "Ghoul", image = "ghoul", backgroundColor = "#8D6E63"),
        Monster(name = "Sticker Monster", image = "sticker_monster", backgroundColor = "#42A5F5"),
        Monster(name = "Pumpkin", image = "pumpkin", backgroundColor = "#FF8A65"),
        Monster(name = "Skull", image = "skull", backgroundColor = "#90A4AE"),
        Monster(name = "Bee", image = "bee", backgroundColor = "#FFD54F"),
        Monster(name = "Frog", image = "frog", backgroundColor = "#9CCC65"),
        Monster(name = "Spider", image = "spider", backgroundColor = "#546E7A"),
        Monster(name = "Cactus", image = "cactus", backgroundColor = "#4DB6AC"),
        Monster(name = "Mushroom", image = "mushroom", backgroundColor = "#E57373"),
    )
}
