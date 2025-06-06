import * as THREE from 'three';

export function initParticles(element) {
    // 1. Create canvas
    const canvas = document.createElement('canvas');
    canvas.style.position = 'fixed';
    canvas.style.top = '0';
    canvas.style.left = '0';
    canvas.style.width = '100%';
    canvas.style.height = '100%';
    canvas.style.zIndex = '-1';
    element.appendChild(canvas);

    // 2. Three.js setup
    const scene = new THREE.Scene();
    const camera = new THREE.PerspectiveCamera(75, 
        window.innerWidth / window.innerHeight, 0.1, 1000);
    const renderer = new THREE.WebGLRenderer({ 
        canvas,
        alpha: true,
        antialias: true
    });
    
    // 3. Particle system
    const geometry = new THREE.BufferGeometry();
    const vertices = [];
    for(let i = 0; i < 1500; i++) {
        vertices.push(
            (Math.random() - 0.5) * 10,
            (Math.random() - 0.5) * 10,
            (Math.random() - 0.5) * 10
        );
    }
    geometry.setAttribute('position', 
        new THREE.Float32BufferAttribute(vertices, 3));
    
    const material = new THREE.PointsMaterial({
        size: 0.05,
        color: 0x888888,
        transparent: true,
        opacity: 0.7
    });
    
    const particles = new THREE.Points(geometry, material);
    scene.add(particles);
    camera.position.z = 5;

    // 4. Mouse interaction
    const mouse = new THREE.Vector2();
    window.addEventListener('mousemove', (e) => {
        mouse.x = (e.clientX / window.innerWidth) * 2 - 1;
        mouse.y = -(e.clientY / window.innerHeight) * 2 + 1;
    });

    // 5. Animation loop
    function animate() {
        requestAnimationFrame(animate);
        
        particles.rotation.x += 0.001;
        particles.rotation.y += 0.002;
        
        const positions = particles.geometry.attributes.position.array;
        for(let i = 0; i < positions.length; i += 3) {
            const dx = positions[i] - mouse.x * 5;
            const dy = positions[i+1] - mouse.y * 5;
            const distance = Math.sqrt(dx*dx + dy*dy);
            
            if(distance < 1.5) {
                const force = (1.5 - distance) * 0.1;
                positions[i] += dx * force;
                positions[i+1] += dy * force;
            }
        }
        particles.geometry.attributes.position.needsUpdate = true;
        renderer.render(scene, camera);
    }
    
    // 6. Handle window resize
    window.addEventListener('resize', () => {
        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(window.innerWidth, window.innerHeight);
    });

    animate();
}
window.initParticles = initParticles;