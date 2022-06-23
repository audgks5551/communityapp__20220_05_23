import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';


export default function AreaCard() {
  return (
      <CardActionArea>
      <Card sx={{ maxWidth: 1100, height: 200 }} className="transition duration-200 ease-in-out transform hover:-translate-y-4 ">
          <CardContent className='p-6'>
          <Typography gutterBottom variant="h5" component="div"> 
            Docker 에 대해서
          </Typography>
          <Typography variant="body2" color="text.secondary">
              Lizards are a widespread group of squamate reptiles, with over 6,000
              species, ranging across all continents except Antarctica
              Lizards are a widespread group of squamate reptiles, with over 6,000
              species, ranging across all continents except Antarctica
              Lizards are a widespread group of squamate reptiles, with over 6,000
              species, ranging across all continents except Antarctica
         
          </Typography>
            <div className='flex'>
              <div className="text-sm mt-4 text-blue-600">[0001]</div>
                <div className="text-sm mt-4 ml-3">
                  2022.4.25.09:44
                </div>
            </div>
          </CardContent>
      </Card>
      </CardActionArea>
  );
}