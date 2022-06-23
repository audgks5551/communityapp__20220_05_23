import Layout from "../../components/Layout";
import { Container } from "@mui/material";
import Stack from "../../components/Stack";
import water from "../../img/water_surface.jpg";
import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import * as React from 'react';
import AreaCard from "../../components/card";

  const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  }));


export default function ArticleList() {
    return (
        <Layout className="flex">

        <div className="mt-20">
            <div className="mb-4">
                전체글
            </div>
            <hr className="mb-10" />
            <Box className="bg-indigo-200 w-full h-[200px]">
                <AreaCard></AreaCard>
            </Box>
            <Box className="bg-indigo-200 w-full h-[200px] mt-4">
                <AreaCard></AreaCard>
            </Box>
            <Box className="bg-indigo-200 w-full h-[200px] mt-4">
                <AreaCard></AreaCard>
            </Box>
            <Box className="bg-indigo-200 w-full h-[200px] mt-4">
                <AreaCard></AreaCard>
            </Box>
            <Box className="bg-indigo-200 w-full h-[200px] mt-4">
                <AreaCard></AreaCard>
            </Box>
            <Box className="bg-indigo-200 w-full h-[200px] mt-4">
                <AreaCard></AreaCard>
            </Box>
            <Box className="bg-indigo-200 w-full h-[200px] mt-4">
                <AreaCard></AreaCard>
            </Box>
            <Box className="bg-indigo-200 w-full h-[200px] mt-4">
                <AreaCard></AreaCard>
            </Box>
        </div>  

            
        </Layout>
                        
    );
}