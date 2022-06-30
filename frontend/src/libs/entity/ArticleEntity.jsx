import React from 'react';
import { atom } from 'recoil';

const articleEntity = atom({
    key: 'articleEntity',
    default: [],
});

export default articleEntity;