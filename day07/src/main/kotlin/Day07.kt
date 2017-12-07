object Day07 {

    private const val CHILDREN_SEPARATOR_STRING = " -> "


    fun getBottomProgramName(input: String): String {
        val programNodes = input.splitAtNewlines()
                .map { parseProgramNode(it) }
        val allChildNodes = mutableSetOf<String>()
        for (node in programNodes) {
            allChildNodes.addAll(node.childrenOnDisc)
        }
        return programNodes
                .firstOrNull { !allChildNodes.contains(it.name) }
                ?.name ?: ""
    }

    private fun parseProgramNode(input: String): ProgramNode {
        val nameAndWeight: String
        val childrenOnDisc: List<String>
        if (input.contains(CHILDREN_SEPARATOR_STRING)) {
            val split = input.split(CHILDREN_SEPARATOR_STRING)
            nameAndWeight = split[0]
            childrenOnDisc = split[1].splitAtCommas().map { it -> it.trim() }
        } else {
            nameAndWeight = input.trim()
            childrenOnDisc = emptyList()
        }
        val nameAndWeightSplit = nameAndWeight.splitAtWhitespace()
        val name: String = nameAndWeightSplit[0]
        val weight: Int = Integer.parseInt(nameAndWeightSplit[1].replace("[()]".toRegex(), ""))

        return ProgramNode(name, weight, childrenOnDisc)
    }

    private data class ProgramNode(
            val name: String,
            val weight: Int,
            val childrenOnDisc: List<String> = emptyList()
    )
}
