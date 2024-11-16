// import * as THREE from 'https://cdn.skypack.dev/three@0.129.0/build/three.module.js';
// import { OrbitControls } from "https://cdn.skypack.dev/three@0.129.0/examples/jsm/controls/OrbitControls.js";
// import { GLTFLoader } from 'https://cdn.skypack.dev/three@0.129.0/examples/jsm/loaders/GLTFLoader.js';
//
// let mouseX = window.innerWidth / 2;
// let mouseY = window.innerHeight / 2;
//
// let isMouseOverCanvas = false;
//
// // Create a Three.js scene
// const scene = new THREE.Scene();
// const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
// const renderer = new THREE.WebGLRenderer();
// renderer.setSize(window.innerWidth, window.innerHeight);
// document.body.appendChild(renderer.domElement);
//
// let object;
// let controls;
//
// let objToRender = 'solana';
//
// // Add lighting
// const light = new THREE.PointLight(0xffffff, 1, 100);
// light.position.set(10, 10, 10);
// scene.add(light);
//
// const ambientLight = new THREE.AmbientLight(0x404040);
// scene.add(ambientLight);
//
// const loader = new GLTFLoader();
//
// loader.load(
//     // Path to the .obj file
//     `/static/solana.glb`,
//
//     function (gltf) {
//         object = gltf.scene;
//
//         scene.add(object);
//     },
//     function (xhr) {
//         console.log(xhr.loaded / xhr.total * 100) + '% loaded'
//     },
//     function (error) {
//         console.error(error);
//     }
// );
//
// const renderer = new THREE.WebGLRenderer({ antialias: true});
// renderer.setSize(window.innerWidth/2, window.innerHeight/2);
// document.getElementById("container3D").appendChild(renderer.domElement);
// //document.getElementById("container3DSec").appendChild(renderer.domElement);
// camera.position.z = objToRender === "solana" ? 4: 25;
//
// const topLight = new THREE.DirectionalLight(0xffffff, 1);
// topLight.position.set(500, 500, 500)
// topLight.castShadow = true;
// scene.add(topLight);
//
// const ambientLight = new THREE.AmbientLight(0x333333, objToRender == "solana" ? 5 : 1);
// scene.add(ambientLight);
//
// if (objToRender === "solana") {
//     controls = new OrbitControls(camera, renderer.domElement);
// }
//
//
// const canvas = renderer.domElement;
// canvas.addEventListener('mouseenter', () => {
//     isMouseOverCanvas = true;
// });
//
// canvas.addEventListener('mouseleave', () => {
//     isMouseOverCanvas = false;
// });
//
// // Update mouse coordinates only when the cursor is on the canvas
// canvas.addEventListener('mousemove', (e) => {
//     if (isMouseOverCanvas) {
//         const rect = canvas.getBoundingClientRect();
//         mouseX = e.clientX - rect.left;
//         mouseY = e.clientY - rect.top;
//     }
// });
//
// function animate() {
//     requestAnimationFrame(animate);
//
//     if (object && objToRender == "solana" && isMouseOverCanvas) {
//         object.rotation.y = -3 + mouseX / canvas.offsetWidth * 3;
//         object.rotation.x = -1.2 + mouseY * 2.5 / canvas.offsetHeight;
//     }
//
//     renderer.render(scene, camera);
// }
//
// window.addEventListener("resize", function() {
//     camera.aspect = window.innerWidth / window.innerHeight;
//     camera.updateProjectionMatrix();
//     renderer.setSize(window.innerWidth, window.innerHeight);
// });
//
// document.onmousemove = (e) => {
//     mouseX = e.clientX;
//     mouseY = e.clientY;
// }
//
// animate();