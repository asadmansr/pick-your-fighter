package com.asadmansoor.fighter.data

interface MonsterRepository {
    suspend fun getMonsters(): List<Monster>
}

class MonsterFighterRepository(
    private val api: MonsterApi = MockMonsterApi(),
) : MonsterRepository {

    override suspend fun getMonsters(): List<Monster> =
        api.getMonsters().take(MAX_MONSTER_LIMIT)

    private companion object {
        const val MAX_MONSTER_LIMIT = 10
    }
}
