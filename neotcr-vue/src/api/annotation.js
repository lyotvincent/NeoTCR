import {request} from "../utils/request";

export function uploadFile(){
    return request({
        method:'POST',
        url:'/upload/file',
        data: files,
        headers:{
            'Content-Type':"multipart/form-data"
        }
    })
}
