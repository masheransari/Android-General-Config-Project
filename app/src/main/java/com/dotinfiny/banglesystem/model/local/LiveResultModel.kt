package com.dotinfiny.banglesystem.model.local

import com.org.dotinfiny.gamesprime.helpers.FunctionID
import com.org.dotinfiny.gamesprime.helpers.RequestID

class LiveResultModel {
    var requestID: RequestID? = null
        private set
    var functionID: FunctionID? = null
        private set
    var resultObject: Any
        private set

    constructor(functionID: FunctionID?, resultObject: Any) {
        this.functionID = functionID
        this.resultObject = resultObject
    }

    constructor(requestID: RequestID?, resultObject: Any) {
        this.requestID = requestID
        this.resultObject = resultObject
    }

}
