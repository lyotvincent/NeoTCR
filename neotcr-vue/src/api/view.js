import {request} from "../utils/request";


export function getView(str){
    return request({
        method:'GET',
        url:'/view/getView',
        params: {filepath:str}
    })
}