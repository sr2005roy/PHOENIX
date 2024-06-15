import { BACKEND_ONE_API_URL } from "../config";
import axios from 'axios';

export const getAllSections = () => {
  return axios.get(`${BACKEND_ONE_API_URL}/sections`)
    .then((response) => response.data)
};

export const getSection = async (sectionId) => {
  return axios.get(`${BACKEND_ONE_API_URL}/sections/${sectionId}`)
    .then((response) => response.data)
};

export const getCategory = async (categoryId) => {
  return axios.get(`${BACKEND_ONE_API_URL}/categories/${categoryId}`)
    .then((response) => response.data)
};

export const getProduct = async (productId) => {
  return axios.get(`${BACKEND_ONE_API_URL}/products/${productId}`)
    .then((response) => response.data)
};

export const getProductsWithText = async (text) => {
  const finalText = text.split(" ").join("+");
  return axios.get(`${BACKEND_ONE_API_URL}/products/search?text=${finalText}`)
    .then((response) => response.data)
};