import React from 'react';
import { Canvas } from '@react-three/fiber';
import { Box } from '@react-three/drei';

const Card3D = () => {
    return (
        <Canvas>
            <ambientLight />
            <pointLight position={[10, 10, 10]} />
            <Box args={[1, 2, 0.1]}>
                <meshStandardMaterial color="orange" />
            </Box>
        </Canvas>
    );
}

export default Card3D;