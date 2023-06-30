import {request} from "../utils/request";

export function getAllTCR(){
    return request({
        method:'GET',
        url:'/browse/getAllTCR'
    })
}

export function getTCR(str){
    return request({
        method:'GET',
        url:'/browse/getTCR',
        params: {selectStr:str}
    })
}

export function getNeo(str){
    return request({
        method:'GET',
        url:'/browse/getNeo',
        params:{cdrs:str}
    })
}

export function getCDR3TCR(str){
    console.log('getCDR3TCR',str)
    return request({
        method:'GET',
        url:'/browse/getCDR3TCR',
        params:{cdrs:str}
    })
}

export function getMcPAS(str){
    console.log('getMcPAS',str)
    return request({
        method:'GET',
        url:'/browse/getMcPAS',
        params:{cdrs:str}
    })
}

export function getAllCDR3(str){
    return request({
        method:'GET',
        url:'/browse/getAllCDR3',
        params:{cdrMap:str}
    })
}

export function getTheTCR(data){
    console.log(data)
    return request({
        method:'POST',
        url:'/browse/getTheTCR',
        headers: {
            'Content-Type': 'multipart/form-data'
            },
        data:  data
    })
}