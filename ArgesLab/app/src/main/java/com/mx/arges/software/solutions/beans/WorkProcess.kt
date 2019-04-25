package com.mx.arges.software.solutions.beans

data class WorkProcess(
    var isHeader: Boolean?,
    var isSection: Boolean?,
    var title: String?,
    var description: String?,
    var icon: String? = null,
    var shortTitle: String? = null,
    var shortDescription: String? = null

)