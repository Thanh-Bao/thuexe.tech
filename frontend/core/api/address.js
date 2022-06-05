import axios from "axios";
import { API_URL } from "../config";

export function getProvince() {
    return new Promise((resolve, reject) => {
        axios.get(`${API_URL}/provinces`, {
        }).then(response => {
            resolve(response.data);
        }).catch(error => reject(error))
    })
}

export function getDistrict(id) {
    return new Promise((resolve, reject) => {
        axios.get(`${API_URL}/provinces/${id}/districts`, {
        }).then(response => {
            resolve(response.data);
        }).catch(error => reject(error))
    })
}

export function getWard(id) {
    return new Promise((resolve, reject) => {
        axios.get(`${API_URL}/districts/${id}/wards`, {
        }).then(response => {
            resolve(response.data);
        }).catch(error => reject(error))
    })
}