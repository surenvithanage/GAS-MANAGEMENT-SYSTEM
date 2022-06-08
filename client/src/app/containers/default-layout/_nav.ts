import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    iconComponent: { name: 'cil-speedometer' }
  },
  {
    name: 'User Management',
    url: '/users',
    iconComponent: { name: 'cil-notes' }
  },
  {
    name: 'Shop Management',
    url: '/shops',
    iconComponent: { name: 'cil-notes' }
  },
  {
    name: 'Order Management',
    url: '/orders',
    iconComponent: { name: 'cil-notes' }
  },
  {
    name: 'Stock Management',
    url: '/stocks',
    iconComponent: { name: 'cil-notes' }
  }
];

export const navItemsShop: INavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    iconComponent: { name: 'cil-speedometer' }
  },
  {
    name: 'Shop Management',
    url: '/shops',
    iconComponent: { name: 'cil-notes' }
  },
  {
    name: 'Order Management',
    url: '/orders',
    iconComponent: { name: 'cil-notes' }
  },
  {
    name: 'Stock Management',
    url: '/stocks',
    iconComponent: { name: 'cil-notes' }
  }
];

export const navItemsCustomer: INavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    iconComponent: { name: 'cil-speedometer' }
  },
  {
    name: 'Order Management',
    url: '/orders',
    iconComponent: { name: 'cil-notes' }
  }
];
