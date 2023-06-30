import {request} from "../utils/request";

export function getUMIAnalyse(data){
    return request({
        method:'POST',
        url:'/analyse/getUMIAnalyse',
        headers: {
            'Content-Type': 'multipart/form-data'
            },
        data: data
    })
}

export function getAnalyse(data){
    return request({
        method:'POST',
        url:'/analyse/getAnalyse',
        headers: {
            'Content-Type': 'multipart/form-data'
            },
        data: data
    })
}

export function getDNAAnalyse(data){
    return request({
        method:'POST',
        url:'/analyse/getDNAAnalyse',
        headers: {
            'Content-Type': 'multipart/form-data'
            },
        data: data
    })
}

export function conversion(str){
    return request({
        method:'GET',
        url:'/analyse/conversion',
        params:{fileName:str}
    })
}

export function searchTXTNeo(str){
    console.log(str)
    return request({
        method:'POST',
        url:'/upload/searchtxtneo',
        params:{str:str}
    })
}

export function searchTXTVDJ(str){
    console.log(str)
    return request({
        method:'POST',
        url:'/upload/searchtxtvdj',
        params:{str:str}
    })
}

export function searchTXTMcPAS(str){
    console.log(str)
    return request({
        method:'POST',
        url:'/upload/searchtxtmcpas',
        params:{str:str}
    })
}


export function delFile(str){
    return request({
        method: 'POST',
        url:'/upload/deleteFile',
        params:{fileName:str}
    })
}

export function downFile(data){
    return request({
        method: 'GET',
        url:'/upload/downFile',
        data:data
    })
}