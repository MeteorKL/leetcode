/*
 * @lc app=leetcode id=21 lang=c
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#define DEBUG 1
#if 0
#define NULL (void *)0
struct ListNode
{
  int val;
  struct ListNode *next;
};
#endif

struct ListNode *mergeTwoLists(struct ListNode *l1, struct ListNode *l2)
{
  struct ListNode *head = malloc(sizeof(struct ListNode));
  if (head == NULL)
  {
    return NULL;
  }
  head->next = NULL;
  head->val = 0;
  struct ListNode *p = head;
  int who = 0;
  struct ListNode *list[2] = {l1, l2};
  while (1)
  {
    if (list[who] == NULL ||
             (list[1 - who] != NULL && list[who] != NULL &&
              list[1 - who]->val < list[who]->val))
    {
      who = 1 - who;
    }
    if (list[who] == NULL)
    {
      break;
    }
    struct ListNode *temp = malloc(sizeof(struct ListNode));
    if (temp == NULL)
    {
      return NULL;
    }
    temp->next = NULL;
    temp->val = list[who]->val;
    list[who] = list[who]->next;
    p->next = temp;
    p = temp;
  }
  struct ListNode *temp = head;
  head = head->next;
  free(temp);
  return head;
}

// @lc code=end
